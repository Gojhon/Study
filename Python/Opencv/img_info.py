import cv2

img1 = cv2.imread('cat.bmp',cv2.IMREAD_GRAYSCALE)
img2 = cv2.imread('cat.bmp',cv2.IMREAD_COLOR)

print('type(img) : ' , type(img1))
print('img1.shape : ',img1.shape)
print('img2.shape : ',img2.shape)
print('img2.shape : ',img2.dtype)

h, w = img2.shape[:2] # h: 480, w: 640
print('img2 size: {} x {}'.format(w, h))
if len(img1.shape) == 2:
  print('img1 is a grayscale image')
elif len(img1.shape) == 3:
  print('img1 is a truecolor image')

for y in range(h):
  for x in range(w):
    img1[y,x] = 255
    img2[y,x] = [0,0,255]