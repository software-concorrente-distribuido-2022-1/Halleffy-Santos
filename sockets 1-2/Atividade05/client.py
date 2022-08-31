import socket

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    porta = 8080
    ipHost = '192.168.0.104'
    sock.connect((ipHost, porta))

    idade = str(input())
    data = idade

    sock.send(data.encode())
    
    print(sock.recv(1004).decode())


if __name__ == '__main__':
    main()