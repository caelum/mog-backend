package br.com.caelum.mog.domains.models;

public class CareOfName {
	private String name;
	
	/**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private CareOfName() { }
	
	public CareOfName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
