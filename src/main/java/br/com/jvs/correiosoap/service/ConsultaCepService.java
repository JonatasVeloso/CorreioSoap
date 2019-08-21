package br.com.jvs.correiosoap.service;

import java.io.StringWriter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.jvs.correiosoap.util.JaxbObjectToXML;
import br.com.jvs.correiosoap.ws.AtendeCliente;
import br.com.jvs.correiosoap.ws.AtendeClienteService;
import br.com.jvs.correiosoap.ws.ConsultaCEPResponse;
import br.com.jvs.correiosoap.ws.EnderecoERP;
import br.com.jvs.correiosoap.ws.ObjectFactory;
import br.com.jvs.correiosoap.ws.SQLException_Exception;
import br.com.jvs.correiosoap.ws.SigepClienteException;


public class ConsultaCepService {

	public void consultaCep(String cep) throws SQLException_Exception, SigepClienteException {
		
		AtendeClienteService asl = new AtendeClienteService();
		AtendeCliente ac = asl.getAtendeClientePort();
		EnderecoERP endereco = new EnderecoERP();
		endereco = ac.consultaCEP(cep);
		ConsultaCEPResponse cepResponse = new ConsultaCEPResponse();
		cepResponse.setReturn(endereco);
		ObjectFactory of = new ObjectFactory();
		JAXBElement<ConsultaCEPResponse> retorno = of.createConsultaCEPResponse(cepResponse);
		JaxbObjectToXML jaxbObjectToXML = new JaxbObjectToXML();
		String retornoString = jaxbObjectToXML.JAXBtoString(retorno);
		System.out.println(retornoString);
	}
	
	
	
	public static void main(String[] args) throws SQLException_Exception, SigepClienteException {
		
		ConsultaCepService cp = new ConsultaCepService();
		cp.consultaCep("02141010");
	}
	
}
