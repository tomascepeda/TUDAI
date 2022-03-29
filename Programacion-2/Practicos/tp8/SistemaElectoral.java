package tp8;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class SistemaElectoral {
	
	public abstract double getPorcentajeVotos(Criterio c);
	public abstract int getTotalVotos();
	protected abstract int getVotos(Criterio c);

}
