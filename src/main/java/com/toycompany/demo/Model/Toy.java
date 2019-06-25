package com.toycompany.demo.Model;

public class Toy {

        private String name;
        private String content;

        public Toy(String name , String content){
            this.name = name;
            this.content = content;
        }

        public String getName() { return name;}

        public void setName(String name) { this.name = name; }

        public String getContent() { return content;}

        public void setContent(String content) {this.content = content;}
}
