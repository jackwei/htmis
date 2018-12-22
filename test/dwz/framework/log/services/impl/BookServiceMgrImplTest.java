package dwz.framework.log.services.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.git.db.beans.ResBook;
import com.git.db.mapper.ResBookMapper;
import com.git.db.mapper.ResChapterMapper;
import com.git.util.service.SequenceService;

import dwz.framework.junit.BaseJunitCase;

public class BookServiceMgrImplTest extends BaseJunitCase{
	
	@Autowired
	private ResBookMapper bookMapper;
	
	@Test
	public void testAddBook() {
		
		for (int i = 0; i < 200; i++) {
			try {
				Date now = new Date();
				ResBook po = new ResBook();
				//SequenceService ss = new SequenceService();
				//po.setId((int)ss.getSequence("book"));
				po.setNameCn("测试 book");
				po.setNameEn("test book");
				po.setPublish("book");
				po.setSn("book sn");
				po.setPublishDate(now);
				po.setInsertDate(now);
				po.setUpdateDate(now);
				bookMapper.insert(po);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}

}
