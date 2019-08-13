package br.com.caelum.mog.domains.models;

public class CareOf {
	private String careOfName;
	
	/**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private CareOf() { }
	
	public CareOf(String careOfName) {
		this.careOfName = careOfName;
	}

	public String getCareOfName() {
		return careOfName;
	}
}
