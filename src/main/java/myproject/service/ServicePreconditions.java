package myproject.service;

import javax.persistence.EntityNotFoundException;

public final class ServicePreconditions {

	private ServicePreconditions() {
		throw new AssertionError();
	}

	public static <T> T checkEntityExists(final T entity) {
		if (entity == null) {
			throw new EntityNotFoundException();
		}
		return entity;
	}

	public static void checkEntityExists(final boolean entityExists) {
		if (!entityExists) {
			throw new EntityNotFoundException();
		}
	}

}
