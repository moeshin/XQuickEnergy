package pansong291.xposed.quickenergy.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pansong291.xposed.quickenergy.util.Config;

public class AlipayUser
{
 private static List<AlipayUser> list;
 String name;
 String id;

 public AlipayUser(String i, String n)
 {
  id = i;
  name = n;
 }

 public static List<AlipayUser> getAlipayUserList()
 {
  if(list == null)
  {
   list = new ArrayList<AlipayUser>();
   Set<Map.Entry> idSet = Config.getIdMap().entrySet();
   for(Map.Entry entry: idSet)
   {
    list.add(new AlipayUser(entry.getKey().toString(), entry.getValue().toString()));
   }
  }
  return list;
 }

 public static void remove(String id)
 {
  getAlipayUserList();
  for(int i = 0; i < list.size(); i++)
  {
   if(list.get(i).id.equals(id))
   {
    list.remove(i);
    break;
   }
  }
 }

}
