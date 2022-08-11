import os
file_list = os.listdir('C:\\Users\\kimo8\\OneDrive')
img_files = [file for file in file_list if file.endswith('.jpg')]
print(img_files)

import glob
img_files = glob.glob('C:\\Users\\kimo8\\OneDrive\\*.jpg')
print(img_files)