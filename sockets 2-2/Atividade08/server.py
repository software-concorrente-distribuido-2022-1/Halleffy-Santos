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

        if str(input()) == 'x':
            exit()

def AnalisaSaldo(conec, addr):
    data = conec.recv(1004).decode()

    valor = ""
    args = []
    for x in data:
        if x == ' ':
            args.append(valor)
            valor = ""
        valor += x
    args.append(valor)

    percentualCredito = '0% do valor'
    saldo = float(args[0])
    if saldo >= 0 and saldo <= 200:
        saldo = 0

    elif saldo >= 201 and saldo <= 400:
        saldo *= 0.2
        percentualCredito = '20% do valor'

    elif saldo >= 401 and saldo <= 600:
        saldo *= 0.3
        percentualCredito = '30% do valor'
    
    else:
        saldo *= 0.4
        percentualCredito = '40% do valor'

    conec.send( (str(saldo) + ' ' + percentualCredito + '\n').encode() )

if __name__ == '__main__':
    main()