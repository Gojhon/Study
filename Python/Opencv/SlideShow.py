import glob
import cv2
img_files = glob.glob('C:\\Users\\kimo8\\Downloads\\web\\*.jpg')
print(img_files)
idx = 0
cnt = len(img_files)
while True:
  img = cv2.imread(img_files[idx])
  
  if img is None:
    print('Image load failed!')
    break
  cv2.imshow('image', img)
  if cv2.waitKey(1000) >= 0:
    break
  idx += 1
  if idx >= cnt:
    idx = 0