import threading

class Thread1(threading.Thread):
    def __init__(self,url):
        super().__init__()
        self.url = url
    def run(self):
        print(self.url+' 처리중')

thread1 = Thread1('http://www.youtube.com')
thread1.start()