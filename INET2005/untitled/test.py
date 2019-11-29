import pyautogui
import time
import random
import threading

class Watcher(threading.Thread):
    def __init__(self):
        super().__init__()
        self.finished = False

    def run(self):
        input()
        self.finished = True


flipper = True
test = Watcher()
input()
test.start()

valueToSleep = random.randint(30, 100)

while not test.finished:
    pyautogui.click()
    time.sleep(random.randint(5000, 10000)/10000)
    pyautogui.click()
    time.sleep(random.randint(120000, 350000)/100000)
    x = 0 if random.randint(0, 150) else time.sleep(random.randint(30, 180))


