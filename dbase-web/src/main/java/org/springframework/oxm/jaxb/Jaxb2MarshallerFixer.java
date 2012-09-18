package org.springframework.oxm.jaxb;

public class Jaxb2MarshallerFixer extends Jaxb2Marshaller {

	@Override
	public boolean supports(Class<?> clazz) {
		ClassPathJaxb2TypeScanner scanner = new ClassPathJaxb2TypeScanner(getPackagesToScan());
		scanner.scanPackages();
		Class<?>[] jaxb2Classes = scanner.getJaxb2Classes();
		if(jaxb2Classes != null)
			for(Class<?> jaxb2Class: jaxb2Classes) {
				if(jaxb2Class.equals(clazz))
					return true;
			}
		return super.supports(clazz);
	}
	
}
