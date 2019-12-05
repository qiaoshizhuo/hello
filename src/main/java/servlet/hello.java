package servlet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class hello extends ActionSupport implements ModelDriven {
    private dao dao=new dao();
        private cat cat=new cat();
        public String select() throws Exception {

            List<cat> cats= dao.select(cat.getC_name());
            //转发到actionContext
            ActionContext.getContext().put("cats",cats);
            return "select";
        }
        public String add() throws Exception {
            dao.add(cat);
            return "add";

        }
        public String update() throws Exception {
            dao.update(cat);
            return "update";
        }
        public String delete() throws Exception {
            dao.delete(cat.getC_name());
            return "delete";
        }


        @Override
        public Object getModel() {
            return cat;
        }
}
