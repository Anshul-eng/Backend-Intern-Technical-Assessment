package Wishlist.Demo.Service;

import Wishlist.Demo.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import Wishlist.Demo.Entity.Wishlist;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<Wishlist> getWishlist(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public Wishlist createWishlistItem(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

   // public void deleteWishlistItem(Long id) {
    //    wishlistRepository.deleteById(id);
  //  }


    public void deleteWishlistItem(Long id, String username) {
        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(id);
        if (wishlistOptional.isPresent()) {
            Wishlist wishlist = wishlistOptional.get();
            if (wishlist.getUser().getName().equals(username)) {  // checking authenticate user same as wishlist user
                wishlistRepository.deleteById(id);
            } else {
                throw new AccessDeniedException("User does not have permission to delete this wishlist item");
            }
        } else {
            throw new IllegalArgumentException("Wishlist item with id " + id + " not found");
        }
    }
}
