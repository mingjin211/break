package collections;

public enum DuError {
    E223114("人脸模糊，请重新进行人脸识别", 223114), E223115("光线不足，请重新进行人脸识别", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String err_msg;
    private int err_code;

    // 构造方法
    private DuError(String name, int index) {
        this.err_msg = name;
        this.err_code = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (DuError c : DuError.values()) {
            if (c.getErr_code() == index) {
                return c.err_msg;
            }
        }
        return null;
    }

    // get set 方法
    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }
}