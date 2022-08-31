import socket
import threading

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    porta = 8080
    sock.bind(('', porta))
    sock.listen(5)

    print('Server criado')

    while True:
        conec, addr = sock.accept()
        threading.Thread(target = AnalisaSaldo, args = (conec, addr), daemon = True).start()

def AnalisaSaldo(conec, addr):
    data = conec.recv(1004).decode()

    args = [""]
    ind = 0
    for x in data:
        if x == ' ':
            ind += 1
        args[ind] += x

    saldo = float(args[0])
    if saldo >= 0 and saldo <= 200:
        saldo = 0

    elif saldo >= 201 and saldo <= 400:
        saldo *= 0.2

    elif saldo >= 401 and saldo <= 600:
        saldo *= 0.3
    
    else:
        saldo *= 0.4

    conec.send( str(saldo).encode() )

if __name__ == '__main__':
    main()