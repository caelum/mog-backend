package br.com.caelum.mog.enums;

public enum CaelumDistrict {

    SP {
        @Override
        public String getName() {
            return "São Paulo";
        }

        @Override
        public String getEmail() {
            return "corporativo@caelum.com.br";
        }

        @Override
        public String getTelephone() {
            return "(11) 4118-3825";
        }

    },

    RJ {

        @Override
        public String getName() {
            return "Rio de Janeiro";
        }

        public String getEmail() {
            return "contato.rj@caelum.com.br";
        }

        @Override
        public String getTelephone() {
            return "(11) 4118-3825";
        }
    },

    BSB {
        @Override
        public String getName() {
            return "Brasília";
        }

        @Override
        public String getEmail() {
            return "contato.df@caelum.com.br";
        }

        @Override
        public String getTelephone() {
            return "(11) 4118-3825";
        }
    };

    public String getName() {
        return "";
    }

    public String getEmail() {
        return "";
    }

    public String getTelephone() {
        return "";
    }
}
