package com.example.sridhar.shealthdemo.FragmentClasses;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import static com.example.sridhar.shealthdemo.JavaClasses.GlobalClass.isHome;
import static com.example.sridhar.shealthdemo.JavaClasses.GlobalClass.package_name;
import com.example.sridhar.shealthdemo.R;

/**
 * Created by sridhar on 3/8/2018.
 */

public class ContentFragment extends Fragment {
/*Alt + Insert to get a list of method*/
    View myView;
    String Header,Content;
    TextView Header_Text, Content_Text;
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Header = getArguments().getString("Header");
        Content = getArguments().getString("Content");
        myView = inflater.inflate(R.layout.content_layout,container,false);
        Header_Text = (TextView) myView.findViewById (R.id.header);
        Content_Text = (TextView) myView.findViewById (R.id.content);
        Header_Text.setText(getStringFromResourcesByName(Header));
        Content_Text.setText(getStringFromResourcesByName(Content));
        isHome=false;
        return myView;
    }
    private String getStringFromResourcesByName(String resourceName){
        /*
            getPackageName()
                Return the name of this application's package.
        */
        // Get the application package name
        String packageName = package_name;

        /*
            getResources()
                Return a Resources instance for your application's package.
        */
        /*
            public int getIdentifier (String name, String defType, String defPackage)
                Return a resource identifier for the given resource name. A fully qualified resource
                name is of the form "package:type/entry". The first two components (package and type)
                are optional if defType and defPackage, respectively, are specified here.

                Note: use of this function is discouraged. It is much more efficient to retrieve
                resources by identifier than by name.

            Parameters
                name String: The name of the desired resource.

                defType String: Optional default resource type to find, if "type/" is
                    not included in the name. Can be null to require an explicit type.

                defPackage String: Optional default package to find, if "package:" is not
                    included in the name. Can be null to require an explicit package.
            Returns
                int : int The associated resource identifier. Returns 0 if no such resource
                    was found. (0 is not a valid resource ID.)
        */
        // Get the string resource id by name
        int resourceId = getResources().getIdentifier(resourceName,"string",packageName);

        // Return the string value
        return getString(resourceId);
    }
}
