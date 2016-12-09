package test;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

public class TestURI {

	//Test de validFragment(String value)
	@Test
	public void testvalidFragment1(){
		String value = "truc";
		assertTrue(URI.validFragment(value));
	}
	@Test
	public void testvalidFragment2(){
		String value = null;
		assertTrue(URI.validFragment(value));
	}
	
	//Test de validOpaquePart(String value)
	@Test
	public void testvalidOpaquePart1(){
		String value = null;
		assertFalse(URI.validOpaquePart(value));
	}
	@Test
	public void testvalidOpaquePart2(){
		String value = "";
		assertFalse(URI.validOpaquePart(value));
	}
	@Test
	public void testvalidOpaquePart3(){
		String value = "truc#";
		assertFalse(URI.validOpaquePart(value));
	}
	@Test
	public void testvalidOpaquePart4(){
		String value = "/truc";
		assertFalse(URI.validOpaquePart(value));
	}
	@Test
	public void testvalidOpaquePart5(){
		String value = "truc";
		assertTrue(URI.validOpaquePart(value));
	}
	
	// Test de validScheme(String value)
	@Test
	public void testValidScheme1() {
		String value = "truc/";
		assertFalse(URI.validScheme(value));
	}
	@Test
	public void testValidScheme2() {
		String value = "truc?";
		assertFalse(URI.validScheme(value));	
	}
	@Test
	public void testValidScheme3() {
		String value = "truc#";
		assertFalse(URI.validScheme(value));
	}
	@Test
	public void testValidScheme4() {
		String value = null;
		assertTrue(URI.validScheme(value));
	}
	@Test
	public void testValidScheme5() {
		String value = "truc";
		assertTrue(URI.validScheme(value));
	}
	
	//Test de validDevice(String value)
	@Test
	public void testValidDevice1(){
		String value = "device/";
		assertFalse(URI.validDevice(value));
	}
	@Test
	public void testValidDevice2(){
		String value = "device?";
		assertFalse(URI.validDevice(value));
	}
	@Test
	public void testValidDevice3(){
		String value = "device#";
		assertFalse(URI.validDevice(value));
	}
	@Test
	public void testValidDevice4(){
		String value = "device";
		assertFalse(URI.validDevice(value));
	}
	@Test
	public void testValidDevice5(){
		String value = "device:";
		assertTrue(URI.validDevice(value));
	}
	@Test
	public void testValidDevice6(){
		String value = null;
		assertTrue(URI.validDevice(value));
	}
	
	//Test de validArchiveAuthority(String value)
	@Test
	public void testValidArchiveAuthority1(){
		String value = "authority#machin";
		assertFalse(URI.validArchiveAuthority(value));
	}
	@Test
	public void testValidArchiveAuthority2(){
		String value = "authority?truc";
		assertFalse(URI.validArchiveAuthority(value));
	}
	@Test
	public void testValidArchiveAuthority3(){
		String value = "authority";
		assertFalse(URI.validArchiveAuthority(value));
	}
	@Test
	public void testValidArchiveAuthority4(){
		String value = "authority!";
		assertTrue(URI.validArchiveAuthority(value));
	}
	
	//Test de validJarAuthority(String value)
	/*@Test
	public void testValidJarAuthority1(){
		String value = "authority#machin";
		assertFalse(URI.validJarAuthority(value));
	}
	@Test
	public void testValidJarAuthority2(){
		String value = "authority?truc";
		assertFalse(URI.validJarAuthority(value));
	}
	@Test
	public void testValidJarAuthority3(){
		String value = "authority";
		assertFalse(URI.validJarAuthority(value));
	}
	@Test
	public void testValidJarAuthority4(){
		String value = "authority!";
		assertTrue(URI.validJarAuthority(value));
	}*/
	
	//Test de validAuthority(String value)
	@Test
	public void testValidAuthority1(){
		String value = "authority#machin";
		assertFalse(URI.validAuthority(value));
	}
	@Test
	public void testValidAuthority2(){
		String value = "authority?truc";
		assertFalse(URI.validAuthority(value));
	}
	@Test
	public void testValidAuthority3(){
		String value = "authority/truc";
		assertFalse(URI.validAuthority(value));
	}
	@Test
	public void testValidAuthority4(){
		String value = "authority";
		assertTrue(URI.validAuthority(value));
	}
	@Test
	public void testValidAuthority5(){
		String value = null;
		assertTrue(URI.validAuthority(value));
	}
	
	//Test de validSegment(String value)
	@Test
	public void testValidSegment1(){
		String value = null;
		assertFalse(URI.validSegment(value));
	}
	@Test
	public void testValidSegment2(){
		String value = "segment?";
		assertFalse(URI.validSegment(value));
	}
	@Test
	public void testValidSegment3(){
		String value = "segment#";
		assertFalse(URI.validSegment(value));
	}
	@Test
	public void testValidSegment4(){
		String value = "segment/";
		assertFalse(URI.validSegment(value));
	}
	@Test
	public void testValidSegment5(){
		String value = "segment";
		assertTrue(URI.validSegment(value));
	}
	
	//Test de validSegments(String[] value)
	@Test
	public void testValidSegments1(){
		String[] values = null;
		assertFalse(URI.validSegments(values));
	}
	@Test
	public void testValidSegments2(){
		String[] values = {"segment1","segment2/","segment3"};
		assertFalse(URI.validSegments(values));
	}
	@Test
	public void testValidSegments3(){
		String[] values = {"segment1","segment2","segment3"};
		assertTrue(URI.validSegments(values));
	}
	
	//Test de validQuery(String value)
	@Test
	public void testValidQuery1(){
		String value = "query#truc";
		assertFalse(URI.validQuery(value));
	}
	@Test
	public void testValidQuery2(){
		String value = null;
		assertTrue(URI.validQuery(value));
	}
	@Test
	public void testValidQuery3(){
		String value = "query";
		assertTrue(URI.validQuery(value));
	}
			
	//Test de isArchiveScheme(String value)
	@Test
	public void testIsArchiveScheme1(){
		String value = "txt";
		assertFalse(URI.isArchiveScheme(value));
	}
	@Test
	public void testIsArchiveScheme2(){
		String value = "jar";
		assertTrue(URI.isArchiveScheme(value));
	}
	
	//Test de createGenericURI(String scheme, String opaquePart, String fragment)
	@Test(expected=IllegalArgumentException.class)
	public void testCreateGenericURI1(){
		String scheme = null;
		String opaquePart = "truc";
		String fragment = "truc";
		URI.createGenericURI(scheme, opaquePart, fragment);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCreateGenericURI2(){
		String scheme = "jar";
		String opaquePart = "truc";
		String fragment = "truc";
		URI.createGenericURI(scheme, opaquePart, fragment);
	}
	@Test
	public void testCreateGenericURI3(){
		String scheme = "truc";
		String opaquePart = "truc";
		String fragment = "truc";
		URI uri = URI.createGenericURI(scheme, opaquePart, fragment);
		assertEquals(uri.toString(), "truc:truc#truc");
	}

	//Test de createHierarchicalURI(String scheme, String authority, String device, String query, String fragment)
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIA1(){
		String scheme = "truc";
		String authority = null;
		String device = null;
		String query = "truc";
		String fragment = "truc";
		URI.createHierarchicalURI(scheme, authority, device, query, fragment);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIA2(){
		String scheme = "jar";
		String authority = "truc";
		String device = "truc";
		String query = "truc";
		String fragment = "truc";
		URI.createHierarchicalURI(scheme, authority, device, query, fragment);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCreateHierarchicalURIA3(){
		String scheme = "truc";
		String authority = "truc";
		String device = "device/";
		String query = "truc";
		String fragment = "truc";
		URI.createHierarchicalURI(scheme, authority, device, query, fragment);
	}
	@Test
	public void testCreateHierarchicalURIA4(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertEquals(uri.toString(), "scheme://authority/device:?query#fragment");
	}
	
	//Test de createURI(String uri)
	@Test(expected=IllegalArgumentException.class)//là c'est chiant
	public void testCreateURIA1(){
		String value = "";
		URI.createURI(value);
	}
	@Test
	public void testCreateURIA2(){
		String value = "foo://truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertEquals(uri.toString(), "foo://truc/bidule/machin");
	}
	
	//Test de isRelative()
	@Test
	public void testIsRelative1(){
		String value = "foo://truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertFalse(uri.isRelative());
	}
	@Test
	public void testIsRelative2(){
		String value = "truc/bidule/machin";
		URI uri = URI.createURI(value);
		assertTrue(uri.isRelative());
	}
	
	//Test de isHierarchical()
	@Test
	public void testIsHierachical1(){
		String value = "truc:";
		URI uri = URI.createURI(value);
		assertFalse(uri.isHierarchical());
	}
	@Test
	public void testIsHierachical2(){
		String scheme = "scheme";
		String authority = "authority";
		String device = "device:";
		String query = "query";
		String fragment = "fragment";
		URI uri = URI.createHierarchicalURI(scheme, authority, device, query, fragment);
		assertTrue(uri.isHierarchical());
	}
	
	
	
}

