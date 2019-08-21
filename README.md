# CorreioSoap
Consumindo soap do Correios https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl

Criado para ficar como exemplo de como consumir um API

Comando para criar as Classes de acordo com o WSDL :
  
  wsimport -keep -d C:\Desenv\correio\src\main\java -p br.com.jvs.correio.ws "https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl"
