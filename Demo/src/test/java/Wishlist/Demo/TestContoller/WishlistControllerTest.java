package Wishlist.Demo.TestContoller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import Wishlist.Demo.Controller.WishlistController;
import Wishlist.Demo.Entity.UserInfo;
import Wishlist.Demo.Entity.Wishlist;
import Wishlist.Demo.Service.WishlistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

@ExtendWith(MockitoExtension.class)
public class WishlistControllerTest {

    @Mock
    private WishlistService wishlistService;

    @InjectMocks
    private WishlistController wishlistController;

    @Test
    public void testCreateWishlistItem() {
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setName("username");
        Wishlist wishlist = new Wishlist(user, "item name");

        when(wishlistService.createWishlistItem(any(Wishlist.class))).thenReturn(wishlist);

        Wishlist createdWishlist = wishlistController.createWishlistItem(wishlist, mock(Authentication.class));

        assertEquals("item name", createdWishlist.getItemName());
        assertEquals(user, createdWishlist.getUser());
    }
}
