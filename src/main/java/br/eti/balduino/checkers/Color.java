package br.eti.balduino.checkers;

public enum Color {
    NONE {
        @Override
        public String toString() {
            return " ";
        }
    },
    BLACK {
        @Override
        public String toString() {
            return "#";
        }
    },
    WHITE {
        @Override
        public String toString() {
            return "o";
        }
    }
}
