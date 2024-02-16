package Wishlist.Demo.Controller;


import Wishlist.Demo.Entity.UserInfo;
import Wishlist.Demo.Service.UserInfoService;
import Wishlist.Demo.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import Wishlist.Demo.Entity.Wishlist;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private UserInfoService userService;

    @GetMapping
    public List<Wishlist> getWishlist(Authentication authentication) {       //taking Authentication object to know that which user's wishlist have to fetch
        String username = authentication.getName();
        Optional<UserInfo> userOptional = userService.getUserByUsername(username);
        if (userOptional.isPresent()) {
            UserInfo user = userOptional.get();
            return wishlistService.getWishlist((long) user.getId());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    @PostMapping
    public Wishlist createWishlistItem(@RequestBody Wishlist wishlist, Authentication authentication) {
        String username = authentication.getName();
        Optional<UserInfo> userOptional = userService.getUserByUsername(username);
        if (userOptional.isPresent()) {
            UserInfo user = userOptional.get();
            wishlist.setUser(user);
            return wishlistService.createWishlistItem(wishlist);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteWishlistItem(@PathVariable Long id, Authentication authentication) {
        String username = authentication.getName();
        wishlistService.deleteWishlistItem(id, username);
    }



}