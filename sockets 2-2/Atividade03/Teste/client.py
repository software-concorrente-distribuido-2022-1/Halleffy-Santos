import socket

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    porta = 8080
    ipHost = '192.168.0.104'
    sock.connect((ipHost, porta))

    n1 = int(input())
    n2 = int(input())
    n3 = int(input())
    data = str(n1) + " " + str(n2) + " " + str(n3)

    sock.send(data.encode())
    print(sock.recv(1024).decode())


if __name__ == '__main__':
    main()