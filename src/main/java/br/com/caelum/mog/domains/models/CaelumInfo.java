package br.com.caelum.mog.domains.models;

import br.com.caelum.mog.enums.CaelumDistrict;

public class CaelumInfo {

    private CaelumDistrict caelumDistrict;

    public CaelumInfo(CaelumDistrict caelumDistrict){
        this.caelumDistrict = caelumDistrict;
    }

    public String getDistrictName() {
        return caelumDistrict.getName();
    }

    public String getDistrictEmail() {
        return caelumDistrict.getEmail();
    }

    public String getDistrictTelephone() {
        return caelumDistrict.getTelephone();
    }

}
