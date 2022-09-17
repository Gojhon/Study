import sys
from tkinter import Frame
import cv2

cap = cv2.VideoCapture(0)

if not cap.isOpened():
    print("Camera open failed!")
    sys.exit()

print('',int(cap.get(cv2.CAP_PROP_FRAME_WIDTH)))
print('',int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT)))

while True : 
  ret , Frame = cap.read()

  if not ret : 
    break

  inversed = ~Frame

  cv2.imshow('frame',Frame)
  cv2.imshow('inversed',inversed)
  if cv2.waitKey(10) == 27:
        break

cap.release()
cv2.destroyAllWindows()