import json
import socket

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    porta = 8080
    ipHost = '192.168.0.113'
    sock.connect((ipHost, porta))
    sock.settimeout(2)

    print("Digite os valores:")

    nome = str(input())
    nivel = str(input())

    print("Valores pegos")

    data = nome + " " + nivel
    sock.send(data.encode())
    
    valor = sock.recv(1024).decode('utf-8')
    print(valor)

    print("End")

if __name__ == '__main__':
    main()