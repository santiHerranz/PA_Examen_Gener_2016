package cat.tecnocampus;

    public class Joguina {

        public static final int OIDA=1;
        public static final int OLFAT=2;
        public static final int VISTA=3;
        public static final int GUST=4;
        public static final int TACTE=5;
        private int identificacio; //identifica la joguina private int edatMinim;
        private int edatMinim;
        private int edatMaxim;
        private int sentit1;
        private int sentit2;
        private int grauIdonietat; //valor [0,10]

        private int sexe; // 0‐‐> nen; 1‐‐> nena; 2‐‐> ambdos

        public Joguina(int iden, int edatMinim, int edatMaxim, int sentit1, int sentit2, int grau, int sexe){
            this.identificacio=iden;
            this.edatMinim=edatMinim;
            this.edatMaxim=edatMaxim;
            this.sentit1=sentit1;this.sentit2=sentit2;
            this.grauIdonietat=grau;
            this.sexe=sexe;
        }



        public int getIdentificador(){return identificacio;}
        public int getEdatMinima(){return edatMinim;}
        public int getEdatMaxim(){return edatMaxim;}
        public int getSentit1(){return sentit1;}
        public int getSentit2(){return sentit2;}
        public int getGrauIdonietat(){return grauIdonietat;}
        public int getSexe(){return sexe;}
    }


