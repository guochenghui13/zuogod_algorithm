/**
 * @(#)charStr.java, 12月 10, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package violence;




import com.sun.tools.javac.util.List;

import java.util.ArrayList;

/**
 * @author guochenghui
 */
public class charStr {

    public static void main(String[] args) {
        char[] tmp = new char[]{'a', 'b', 'c'};
        process(tmp, 0);
    }

    public static void process(char[] str, int i){
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process(str, i + 1);
        char tmp = str[i];
        str[i] = 0;
        process(str, i + 1);
        str[i] = tmp;
    }

}