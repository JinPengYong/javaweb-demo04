import com.cheer.model.Question;
import com.cheer.service.QuestionService;
import com.cheer.service.impl.QuestionServiceImpl;

import java.util.List;


/**
 * Author: Dreamer-1
 * Date: 2019-03-01
 * Time: 10:13
 * Description: 示例程序入口类
 */
public class MainTest {

    public static void main(String[] args) {
        QuestionService questionService=new QuestionServiceImpl();
        // 设定Excel文件所在路径
        String excelFileName = "C:\\Users\\Administrator\\Desktop\\questions.xlsx";
        // 读取Excel文件内容
        List<Question> questionList = ExcelReader.readExcel(excelFileName);
        for (Question q : questionList) {
            questionService.insert(q);
            System.out.println(q);
        }

        // todo 进行业务操作
    }

}