package nl.iprwc.persistence;

public class DatabaseInfo {

public final static String itemTableName = "item";
    public class itemColumnNames {
        public static final String id = "id";
        public static final String name = "name";
        public static final String description = "description";
        public static final String price = "price_cents";
    }

public final static String accountTableName = "account";
    public class accountColumnNames {
        public static final String email = "email";
        public static final String password = "password";
        public static final String is_admin = "is_admin";
    }

public final static String locationTableName = "location";
    public class locationColumnNames {
        public static final String account_email = "account_email";
        public static final String street_name = "street_name";
        public static final String house_nr = "house_nr";
        public static final String zipcode = "zipcode";
        public static final String city = "city";
    }

    public final static String basketTableName = "basket";
    public class basketColumnNames {
        public static final String account_email = "account_email";
        public static final String street_name = "street_name";
    }


}
