import zmq
import time

class FakingPlayerInterface:
    def __init__(self):
        self._context = zmq.Context()
        self._socket = self._context.socket(zmq.REQ)
        self._socket.connect("tcp://127.0.0.1:23333")

    def getMoves(self):
        self._socket.send("getMoves")
        s = self._socket.recv() # type: str
        return s.splitlines()

    def returnMove(self, moveIndex):
        self._socket.send("returnMove")
        self._socket.recv()
        self._socket.send("0")
        self._socket.recv()

if __name__ == '__main__':
    player = FakingPlayerInterface()

    while True:
        start = time.clock()
        print("----------")

        print(player.getMoves())

        print(time.clock() - start)
        start = time.clock()

        player.returnMove(0)

        print(time.clock() - start)

