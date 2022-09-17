import sys
import cv2


cap = cv2.VideoCapture('C:\\Users\\kimo8\\Videos\\메이의 새빨간 비밀 (우리말) Turning Red,2022.720p.KORDUB.HDRip.H264.AAC-FST.mp4')

if not cap.isOpened():
    print("Video open failed!")
    sys.exit()

print('', int(cap.get(cv2.CAP_PROP_FRAME_WIDTH)))
print('', int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT)))
print('', int(cap.get(cv2.CAP_PROP_FRAME_COUNT)))

fps = cap.get(cv2.CAP_PROP_FPS)
print('FPS:', fps)

delay = round(1000 / fps)

while True:
    ret, frame = cap.read()

    if not ret:
        break

    inversed = ~frame  # 반전

    cv2.imshow('frame', frame)
    cv2.imshow('inversed', inversed)

    if cv2.waitKey(delay) == 27:
        break

cap.release()
cv2.destroyAllWindows()
