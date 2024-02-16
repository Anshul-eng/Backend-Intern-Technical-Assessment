package Wishlist.Demo.Service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import Wishlist.Demo.Entity.UserInfo;
import Wishlist.Demo.Entity.Wishlist;
import Wishlist.Demo.Repository.WishlistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WishlistServiceTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private WishlistService wishlistService;

    @Test
    public void testCreateWishlistItem() {
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setName("username");
        Wishlist wishlist = new Wishlist(user, "item name");

        when(wishlistRepository.save(any(Wishlist.class))).thenReturn(wishlist);

        Wishlist createdWishlist = wishlistService.createWishlistItem(wishlist);

        assertEquals("item name", createdWishlist.getItemName());
        assertEquals(user, createdWishlist.getUser());
    }
}

