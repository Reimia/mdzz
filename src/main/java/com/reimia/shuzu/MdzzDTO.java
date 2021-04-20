package com.reimia.shuzu;

public class MdzzDTO {

    private String a;

    private MdzzChildDTO mdzzChildDTO = new MdzzChildDTO();

    public MdzzChildDTO getMdzzChildDTO() {
        return mdzzChildDTO;
    }

    public void setMdzzChildDTO(MdzzChildDTO mdzzChildDTO) {
        this.mdzzChildDTO = mdzzChildDTO;
    }

    public void setMdzzChildDTOstring(String s){
        mdzzChildDTO.setString(s);
    }

    private class MdzzChildDTO extends MdzzDTO {

        private String string;

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return "MdzzChildDTO{" +
                    "mdzzChildDTO=" + mdzzChildDTO +
                    ", string='" + string + '\'' +
                    '}';
        }
    }


}
