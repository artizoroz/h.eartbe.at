/**
 * 
 */
package at.eartbe.h.backend.data;

import java.util.List;

import at.eartbe.h.backend.data.dao.AvatarDAO;
import at.eartbe.h.backend.data.dao.impl.HibernateAvatarDAO;
import at.eartbe.h.backend.data.model.Avatar;

/**
 * @author Asier
 *
 */
public class AvatarMain {

	/**
	 * @param args
	 */
	public static void showAll(AvatarDAO AvatarDAO) {
		// SELECT ALL DATA
		List<Avatar> avatars = AvatarDAO.selectAll();
		System.out.println("--- USER ----- table contents	-----------");
		for (Avatar avatar : avatars) {
			System.out.println("Id: " + avatar.getId());
			System.out.println(" - IMAGE: " + avatar.getImage());
			System.out.println(" - DESCRIPTION: " + avatar.getDescription());
		}
		System.out.println("Total Avatars: " + avatars.size());
	}
	public static void main(String[] args) {
		AvatarDAO avatarDAO = new HibernateAvatarDAO();
		showAll(avatarDAO);

		// INSERT NEW DATA
		Avatar newAvatar = new Avatar(1l,"imagen1","/1.jpg");
		avatarDAO.insert(newAvatar);
		System.out.println("Inserted id: " + newAvatar.getId());
		newAvatar = new Avatar(1l,"imagen2","/2.jpg");
		avatarDAO.insert(newAvatar);
		System.out.println("Inserted id: " + newAvatar.getId());		
		System.out.println("\nShow data after new insert");
		showAll(avatarDAO);
		
		// SELECT JUST ONE
		Avatar oneAvatar = avatarDAO.selectById(Long.valueOf(1));
		System.out.println("\nShow the avatar with ID=1");
		System.out.println("--- AVATAR ----- table contents	-----------");
		System.out.println("Selected Image: " + oneAvatar.getImage());

		// UPDATE DATA
		newAvatar.setDescription("imagen1.0");;
		avatarDAO.update(newAvatar);
		System.out.println("\nShow data after update");
		showAll(avatarDAO);

		// DELETE DATA
		avatarDAO.delete(newAvatar);
		System.out.println("\nShow data after deletion");
		showAll(avatarDAO);
	}

}
