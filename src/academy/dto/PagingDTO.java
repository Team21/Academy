package academy.dto;

import academy.util.Utilities;

/**
 * ����¡ ó������ bean <br>
 * page : �Խù� ����
 * page group : page ����
 * @author kgmyh
 *
 */
public class PagingDTO {
	/**
	 * �� ������(�Խù�)�� ����
	 */
	private int totalContent;
	/**
	 * ���� ������
	 */
	private int currentPage;
	/**
	 * �� �������� ������ ������(�Խù�)����
	 */
	private int contentsPerPage = Utilities.CONTENT_PER_PAGE;
	/**
	 * Page Group �� Page ��.  ������ �׷쿡 �� ������ ����
	 */
	private int pagePerPagegroup = Utilities.PAGE_PER_PAGEGROUP;
	
	/**
	 * �� ������(�Խù�) ����, ���� �������� �޾� member variable�� �Ҵ�
	 * @param totalContent
	 * @param currentPage
	 */
	public PagingDTO(int totalContent, int nowPage){
		this.totalContent = totalContent;
		this.currentPage = nowPage;
	}
	/**
	 * ���� ������ return
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * ���� ������ setting
	 * @param nowPage
	 */
	public void setCurrentPage(int nowPage) {
		this.currentPage = nowPage;
	}

/***************************************************************************
* �Ʒ� �޼ҵ���� �����Ͻÿ�.
****************************************************************************/

	/**
	 * �� ������ ���� return�Ѵ�.<br>
	 * 1. ��ü ������(�Խù�) % �� �������� ������ ������ ���� => 0 �̸� ���� /  ���� �� ������ ��<br>
	 * 2. ��ü ������(�Խù�) % �� �������� ������ ������ ���� => 0���� ũ�� ���� /  ���� +1�� �� ���� �� ������ ��
	 * @return
	 */
	public int getTotalPage(){
		int totalPage = totalContent / contentsPerPage;
		
		if(totalContent % contentsPerPage != 0) {
			totalPage++;
		}
		return totalPage;
	}
	
	/**
	 * �� ������ �׷��� ���� return�Ѵ�.<br>
	 * 1. �� �������� %  Page Group �� Page ��.  => 0 �̸� ���� /  ���� �� ������ ��<br>
	 * 2. �� �������� %  Page Group �� Page ��.  => 0���� ũ�� ���� /  ���� +1�� �� ���� �� ������ ��
	 * @return
	 */
	public int getTotalPageGroup(){
		int totalPageGroup = getTotalPage() / pagePerPagegroup;
		
		if(getTotalPage() % pagePerPagegroup != 0) {
			totalPageGroup++;
		}
		
		return totalPageGroup;
	}
	/**
	 * ���� �������� ���� ������ �׷� ��ȣ(�� ��° ������ �׷�����) �� return �ϴ� �޼ҵ�
	 * 1. ���� ������ %  Page Group �� Page �� => 0 �̸� ���� / ���� ���� ������ �׷�. 
	 * 2. ���� ������ %  Page Group �� Page �� => 0 ũ�� ���� /  ���� +1�� �� ���� ���� ������ �׷�
	 * @return
	 */
	public int getCurrentPageGroup(){
		
		int currentPageGroup = getCurrentPage() / pagePerPagegroup;
		
		if(getCurrentPage() % pagePerPagegroup != 0) {
			currentPageGroup++;
		}
		
		return currentPageGroup;
	}
	
	/**
	 * ���� �������� ���� ������ �׷��� ���� ������ ��ȣ�� return �Ѵ�.<br>
	 * 1. Page Group �� Page ��*(���� ������ �׷� -1) + 1�� �� ���� ù �������̴�.(������ �׷�*������ �׷� ���� �� �� �׷��� ������ ��ȣ�̹Ƿ�)
	 * 2. ���� ��� ����� 0�� ���� ù������ �̹Ƿ� 1�� return �Ѵ�. 
	 * @return
	 */
	public int getStartPageOfPageGroup(){
		return pagePerPagegroup * (getCurrentPageGroup() - 1) + 1;
	}
	/**
	 * ���� �������� ���� ������ �׷��� ������ ������ ��ȣ�� return �Ѵ�.<br>
	 * 1. ���� ������ �׷� * ������ �׷� ���� �� ������ ��ȣ�̴�.
	 * 2. �� �׷��� ������ ������ ��ȣ�� ��ü �������� ������ ������ ��ȣ���� ū ���� ��ü �������� ������ ��ȣ�� return �Ѵ�. 
	 * @return
	 */
	public int getEndPageOfPageGroup(){
		int endPage = pagePerPagegroup * getCurrentPageGroup();
		
		if(endPage > getTotalPage()) {
			endPage = getTotalPage();
		}
		
		return endPage;
	}

	/**
	 * ���� ������ �׷��� �ִ��� üũ
	 * ���� �������� ���� ������ �׷��� 1���� ũ�� true
	 * @return
	 */
	public boolean isPreviousPageGroup(){
		return getCurrentPageGroup() > 1;
	}
	/**
	 * ���� ������ �׷��� �ִ��� üũ
	 * ���� ������ �׷��� ������ ������ �׷�(������ ������ �׷� == �� ������ �׷� ��) ���� ������ true
	 * @return
	 */
	public boolean isNextPageGroup(){
		return getCurrentPageGroup() < getTotalPageGroup();
	}
}