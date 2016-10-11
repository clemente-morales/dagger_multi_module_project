package com.blogspot.cmf.android.dagger.core.commands;


import com.blogspot.cmf.android.dagger.core.models.DataFragment;
import com.blogspot.cmf.android.dagger.core.views.FragmentManager;

/**
 * Allows the invoker to replace the current fragment with the new provided fragment.
 *
 * @author Clemente Morales Fernandez
 * @since 10/7/2016.
 */

public class ReplaceFragmentCommand implements Command<FragmentManager> {
    private final DataFragment dataFragment;

    public ReplaceFragmentCommand(DataFragment dataFragment) {
        this.dataFragment = dataFragment;
    }

    @Override
    public void execute(FragmentManager fragmentManager) {
        fragmentManager.addFragment(dataFragment);
    }
}
