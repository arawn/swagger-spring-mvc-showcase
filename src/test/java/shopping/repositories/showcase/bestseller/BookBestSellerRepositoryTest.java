package shopping.repositories.showcase.bestseller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shopping.domain.showcase.BookBestSeller;

import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/database-context.xml")
public class BookBestSellerRepositoryTest {
    
    @Inject
    BookBestSellerRepository bookBestSellerRepository;

    @Test
    public void 년도와_월로_책_베스트셀러_페이징_검색() {
        List<BookBestSeller> 테스트_데이터 = Lists.newArrayList(new BookBestSeller(1L), new BookBestSeller(2L));
        
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        PageRequest pageRequest = new PageRequest(0, 2, new Sort(Direction.ASC, "rank"));

        Page<BookBestSeller> page = bookBestSellerRepository.findByYearAndMonth(year, month, pageRequest);
        
        assertThat(page.getContent(), is(테스트_데이터));
        assertThat(page.getTotalElements(), is(10L));
    }

}
