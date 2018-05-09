package org.rdfhdt.hdtjena;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.ResourceFactory;
import org.rdfhdt.hdt.dictionary.Dictionary;
import org.rdfhdt.hdt.dictionary.DictionarySection;
import org.rdfhdt.hdt.enums.TripleComponentRole;
import org.rdfhdt.hdt.header.Header;

public class NodeDictionaryTest {

	private class DummyDictionary implements Dictionary {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.io.Closeable#close()
		 */
		@Override
		public void close() throws IOException {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#idToString(int,
		 * org.rdfhdt.hdt.enums.TripleComponentRole)
		 */
		@Override
		public CharSequence idToString(final int id,
				final TripleComponentRole position) {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.rdfhdt.hdt.dictionary.Dictionary#stringToId(java.lang.CharSequence
		 * , org.rdfhdt.hdt.enums.TripleComponentRole)
		 */
		@Override
		public int stringToId(final CharSequence str,
				final TripleComponentRole position) {
			// TODO Auto-generated method stub
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getNumberOfElements()
		 */
		@Override
		public long getNumberOfElements() {
			// TODO Auto-generated method stub
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#size()
		 */
		@Override
		public long size() {
			// TODO Auto-generated method stub
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getNsubjects()
		 */
		@Override
		public long getNsubjects() {
			// TODO Auto-generated method stub
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getNpredicates()
		 */
		@Override
		public long getNpredicates() {
			// TODO Auto-generated method stub
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getNobjects()
		 */
		@Override
		public long getNobjects() {
			// TODO Auto-generated method stub
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getNshared()
		 */
		@Override
		public long getNshared() {
			// TODO Auto-generated method stub
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getSubjects()
		 */
		@Override
		public DictionarySection getSubjects() {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getPredicates()
		 */
		@Override
		public DictionarySection getPredicates() {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getObjects()
		 */
		@Override
		public DictionarySection getObjects() {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getShared()
		 */
		@Override
		public DictionarySection getShared() {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.rdfhdt.hdt.dictionary.Dictionary#populateHeader(org.rdfhdt.hdt
		 * .header.Header, java.lang.String)
		 */
		@Override
		public void populateHeader(final Header header, final String rootNode) {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.rdfhdt.hdt.dictionary.Dictionary#getType()
		 */
		@Override
		public String getType() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Test
	public void testLang() {
		final NodeDictionary dict = new NodeDictionary(new DummyDictionary());
		final RDFNode object = ResourceFactory.createLangLiteral("Hello", "en");
		final String s = dict.nodeToStr(object.asNode());
		System.out.println(s);
		assertEquals("\"Hello\"@en", s);
	}

	@Test
	public void testNormal() {
		final NodeDictionary dict = new NodeDictionary(new DummyDictionary());
		final RDFNode object = ResourceFactory.createPlainLiteral("Hello");
		final String s = dict.nodeToStr(object.asNode());
		System.out.println(s);
		assertEquals("\"Hello\"", s);
	}

	@Test
	public void testTyped() {
		final NodeDictionary dict = new NodeDictionary(new DummyDictionary());
		final XSDDatatype type = XSDDatatype.XSDnonNegativeInteger;
		final RDFNode object = ResourceFactory.createTypedLiteral("2", type);
		final String s = dict.nodeToStr(object.asNode());
		System.out.println(s);
		assertEquals(
				"\"2\"^^<http://www.w3.org/2001/XMLSchema#nonNegativeInteger>",
				s);
	}

}
