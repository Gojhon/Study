import threading
import time

def thread_run():
    time.sleep(10)
    print('Hello World')


thread1= threading.Thread(target=thread_run , daemon=True)
thread1.start()
thread1.join()


print('메인 쓰레드는 하위 쓰레드 시작 이후 계속 실행합니다.')