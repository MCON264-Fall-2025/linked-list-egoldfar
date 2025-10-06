package linkedlist;

import org.apache.commons.lang3.NotImplementedException;
import support.CycleInfo;
import support.LLNode;

public class LinkedListCycleAnalyzer<T> {
    public static <T> CycleInfo detectCycleInfo(LLNode<T> head) {

       LLNode <T> h = head;
       LLNode<T> t = head.getLink();
        boolean noLoop = false;

        while(h != t && !noLoop) {
          try {
              h = h.getLink();
              t = t.getLink().getLink();
          }catch(NullPointerException e) {
              noLoop = true;
          }
        }

        if(noLoop) {
            return new CycleInfo(-1, 0);
        }

        int i = 0;
        do{
            h = h.getLink();
            i++;
        }while (h != t);

        int index = -1;

        do {
            if (index != -1) {
                head = head.getLink();
            }

            h = head;

            for (int j = 0; j < i; j++) {
                h = h.getLink();
            }
            index++;
        } while(head != h);

        return new CycleInfo(index, i);
    }
}
