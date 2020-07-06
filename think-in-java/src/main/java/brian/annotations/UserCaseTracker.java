package brian.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserCaseTracker {

    public static void trackerCase(List<Integer> userCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UserCase uc = m.getAnnotation(UserCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:"+uc.id()+" "+uc.desc());
                userCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : userCases) {
            System.out.println("Warning: Missing use case -" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> userCases = new ArrayList<Integer>();
        Collections.addAll(userCases,47, 48, 49, 50);
        trackerCase(userCases, Test.class);

    }
}
