package src.DartSystem;

import java.util.ArrayList;

    public class Membership {

        private String type;
        private int discount;
        private ArrayList<String> customerMember;


        Membership(){
            this.type = null;
        }

        Membership(String type){
            this.type = type;
        }


        public String requestMembership(String type){
            customerMember.add(getType());

            return requestMembership(type);

        }

        public double discount(){
            return 0;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }


