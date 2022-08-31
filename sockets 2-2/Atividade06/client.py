import socket

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    porta = 8080
    ipHost = '192.168.0.104'
    sock.connect((ipHost, porta))

    nome = str(input())
    nivel = str(input())
    salarioBruto = str(input())
    nDependentes = str(input())

    data = nome + " " + nivel + " " + salarioBruto + " " + nDependentes
    sock.send(data.encode())
    salarioLiquido = sock.recv(1004).decode()
    
    print('----Funcionario----')
    print('Nome: ' + nome)
    print('Nivel: ' + nivel)
    print('Numero de dependentes: ' + nDependentes)
    print('Salario bruto: ' + salarioBruto)
    print('Salario liquido: ' + salarioLiquido)


if __name__ == '__main__':
    main()