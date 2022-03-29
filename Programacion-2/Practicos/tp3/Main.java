package envios;

public class Main {

	public static void main(String[] args) {

		Paquete carta = new Paquete(115, true);
		carta.setRemitente("homero", "avenida del libertador, capital");
		carta.setDestinatario("bart", "san andreas");
		
		Paquete carta2 = new Paquete(260, false);
		carta2.setRemitente("ned flanders", "miami");
		carta2.setDestinatario("lisa", "springfield");
		
		Paquete carta3 = new Paquete(10, true);
		carta3.setRemitente("lisa", "avenida siempre viva, springfield");
		carta3.setDestinatario("homero", "planta de energia nuclear, springfield");
		
		Paquete carta4 = new Paquete(40, false);
		carta4.setRemitente("homero", "planta de energia nuclear, springfield");
		carta4.setDestinatario("bart", "san andreas");
		
		Paquete carta5 = new Paquete(300, true);
		carta5.setRemitente("bart", "cordoba");
		carta5.setDestinatario("lisa", "springfield");
		
		Combo comboPostal = new Combo(new CriterioDestino("springfield"));
		Combo comboEmpresarial = new Combo(new CriterioRemitente("homero"));
		Combo comboServicios = new Combo(new CriterioPesoMenor(300));
		
		System.out.println(carta2.toString());
		
		comboPostal.addEnvio(carta);
		comboPostal.addEnvio(carta2);
		comboPostal.addEnvio(carta3);
		comboPostal.addEnvio(carta4);
		comboPostal.addEnvio(carta5);
		
		comboEmpresarial.addEnvio(carta);
		comboEmpresarial.addEnvio(carta2);
		comboEmpresarial.addEnvio(carta3);
		comboEmpresarial.addEnvio(carta4);
		comboEmpresarial.addEnvio(carta5);
		
		comboServicios.addEnvio(carta);
		comboServicios.addEnvio(carta2);
		comboServicios.addEnvio(carta3);
		comboServicios.addEnvio(carta4);
		comboServicios.addEnvio(carta5);
		
		comboPostal.addEnvio(comboEmpresarial);
		comboEmpresarial.addEnvio(comboServicios);
		
		for (ElementoSP i : comboPostal.getEnvios()) {
			System.out.println(i.toString());
		}
		
		System.out.println("nuevos");
		
		for (ElementoSP i : comboPostal.getEnvios(new CriterioRemitente("homero"))) {
			System.out.println(i.toString());
		}
	}
}
