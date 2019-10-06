package io.kanonair.ea;

public enum Season implements Inter {
    SPRING("春天") {
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    },
    SUMMER("夏天") {
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    },
    AUTUMN("秋天") {
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    },
    WINTER("冬天") {
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    };

    private final String name;

    private Season(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
