import threading

def thread_run(url,url2):
    print('Hello World!')

#순차전달
# thread1 = threading.Thread(target=thread_run,args=('http://naver.com','baver.com'))
# thread1.start()

thread1 = threading.Thread(target=thread_run,kwargs=dict(url='http://naver.com',url2='baver.com'))
thread1.start()
