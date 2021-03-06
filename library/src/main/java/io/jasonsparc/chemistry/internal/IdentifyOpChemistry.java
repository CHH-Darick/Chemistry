package io.jasonsparc.chemistry.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.jasonsparc.chemistry.Chemistry;
import io.jasonsparc.chemistry.IdSelector;

/**
 * Created by jason on 15/07/2016.
 */
public final class IdentifyOpChemistry extends BaseIdentifyOpChemistry {
	@NonNull final Class<?> itemClass;
	@Nullable final IdSelector idSelector;

	public <Item> IdentifyOpChemistry(@NonNull Chemistry base, @NonNull Class<? extends Item> itemClass, @Nullable IdSelector<? super Item> idSelector) {
		super(base);
		this.itemClass = itemClass;
		this.idSelector = idSelector;
	}

	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	public <Item> IdSelector<? super Item> findIdSelector(@NonNull Class<? extends Item> itemClass) {
		if (this.itemClass.isAssignableFrom(itemClass)) {
			return idSelector;
		}
		return baseIdSelectorFinder.findIdSelector(itemClass);
	}
}
