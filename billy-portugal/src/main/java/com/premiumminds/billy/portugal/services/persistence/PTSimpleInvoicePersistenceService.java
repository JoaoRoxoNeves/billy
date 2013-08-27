/**
 * Copyright (C) 2013 Premium Minds.
 *
 * This file is part of billy portugal (PT Pack).
 *
 * billy portugal (PT Pack) is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * billy portugal (PT Pack) is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with billy portugal (PT Pack). If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.billy.portugal.services.persistence;

import javax.inject.Inject;

import com.premiumminds.billy.core.exceptions.BillyRuntimeException;
import com.premiumminds.billy.core.persistence.dao.TransactionWrapper;
import com.premiumminds.billy.core.persistence.services.PersistenceService;
import com.premiumminds.billy.core.persistence.services.PersistenceServiceImpl;
import com.premiumminds.billy.core.services.Builder;
import com.premiumminds.billy.core.services.UID;
import com.premiumminds.billy.core.util.NotImplemented;
import com.premiumminds.billy.portugal.persistence.dao.DAOPTSimpleInvoice;
import com.premiumminds.billy.portugal.persistence.entities.PTSimpleInvoiceEntity;
import com.premiumminds.billy.portugal.services.entities.PTSimpleInvoice;

public class PTSimpleInvoicePersistenceService extends
	PersistenceServiceImpl<PTSimpleInvoice> implements
	PersistenceService<PTSimpleInvoice> {

	protected final DAOPTSimpleInvoice	daoInvoice;

	@Inject
	public PTSimpleInvoicePersistenceService(DAOPTSimpleInvoice daoInvoice) {
		this.daoInvoice = daoInvoice;
	}

	@Override
	@NotImplemented
	public PTSimpleInvoice create(final Builder<PTSimpleInvoice> builder) {
		return null;
	}

	@Override
	public PTSimpleInvoice update(final Builder<PTSimpleInvoice> builder) {
		try {
			return new TransactionWrapper<PTSimpleInvoice>(daoInvoice) {

				@Override
				public PTSimpleInvoice runTransaction() throws Exception {
					PTSimpleInvoiceEntity entity = (PTSimpleInvoiceEntity) builder
							.build();
					return (PTSimpleInvoice) daoInvoice.update(entity);
				}

			}.execute();
		} catch (Exception e) {
			throw new BillyRuntimeException(e);
		}
	}

	@Override
	public PTSimpleInvoice get(final UID uid) {
		try {
			return new TransactionWrapper<PTSimpleInvoice>(daoInvoice) {

				@Override
				public PTSimpleInvoice runTransaction() throws Exception {
					return (PTSimpleInvoice) daoInvoice.get(uid);
				}

			}.execute();
		} catch (Exception e) {
			throw new BillyRuntimeException(e);
		}
	}

}
