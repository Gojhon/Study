from tkinter import *
from PIL import ImageTk, Image
from tkinter import filedialog
 
window = Tk()
window.title('filedialog study')
window.geometry("400x100+100+100")
window.resizable(False, False)

def open():
    global my_image #
    window.filename = filedialog.askopenfilename(initialdir='', title='파일선택', filetypes=(
    ('png files', '*.png'), ('jpg files', '*.jpg'), ('all files', '*.*')))
 
    Label(window, text=window.filename).grid(row=0, column=1) # 파일경로 view
    my_image = ImageTk.PhotoImage(Image.open(window.filename))
    Label(image=my_image).grid(row=0, column=0) #사진 view
 
 
my_btn = Button(window, text='파일열기', command=open).grid(row=0, column=2)
 
window.mainloop()
